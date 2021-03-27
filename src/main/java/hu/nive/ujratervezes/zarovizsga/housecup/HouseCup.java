package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.*;

public class HouseCup {
    public static final String SQL_TO_GET_POINTS_BY_HOUSE_NAME = "Select sum(points_earned) points_earned from " +
                                                                "house_points where " +
                                                                "house_name = ? group by house_name";
    private final DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String houseName) {
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(SQL_TO_GET_POINTS_BY_HOUSE_NAME);
            statement.setString(1,houseName);
            return getPointsFromStatement(statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database", sqle);
        }
    }

    private int getPointsFromStatement(PreparedStatement statement) {
        try(statement) {
            ResultSet rs = statement.executeQuery();
            return getPointsFromResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute statement", sqle);
        }
    }

    private int getPointsFromResultSet(ResultSet rs) {
        try (rs) {
            if (rs.next()) {
                return rs.getInt("points_earned");
            }
            return 0;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach result", sqle);
        }
    }
}

//House cup
//Minerva McGalagony megelégelte, hogy Dumbledore mennyire lazán veszi a házak pontversenyét, és saját kezébe vette a dolgokat.
// Mostantól a pontokat transzparens módon, adatbázisban fogjuk vezetni.
//
//Adatbázis
//Az adatbázisban egyetlen tábla van house_points néven, az alábbi oszlopokkal:
//
//house_name varchar
//student_name varchar
//points_earned int
//Egy hallgató többször is szerezhet pontot a tanév során a házának, ilyenkor az több rekordban lesz rögzítve. Például:
//
//house_name	student_name	points_earned
//Gryffindor	Harry Potter	50
//Slytherin	Draco Malfoy	10
//Slytherin	Draco Malfoy	20
//Gryffindor	Harry Potter	-15
//Hufflepuff	Cedric Diggory	25
//Java alkalmazás
//Hozd létre a HouseCup osztályt, ami konstruktor paraméterben megkapja az adatbázis eléréshez szükséges DataSource példányt.
// Az osztályban hozd létre az alábbi metódusokat:
//
//getPointsOfHouse(String houdse): adja vissza, hogy a paraméterként megadott ház mennyi pontot szerzett
