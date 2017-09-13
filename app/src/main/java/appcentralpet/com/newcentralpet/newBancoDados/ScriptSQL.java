package appcentralpet.com.newcentralpet.newBancoDados;

/**
 * Created by Jadson on 13/09/2017.
 */
public class ScriptSQL {

    public static String getCreatePet(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" CREATE TABLE IF NOT EXISTS PET ( ");
        sqlBuilder.append("_id          INTEGER NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("name         VARCHAR (14), ");
        sqlBuilder.append("sexo         VARCHAR (6), ");
        sqlBuilder.append("raca         VARCHAR (14), ");
        sqlBuilder.append("tipo         VARCHAR (6), ");
        sqlBuilder.append("idade        VARCHAR (6), ");
        sqlBuilder.append("image        BLOB ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }
}
