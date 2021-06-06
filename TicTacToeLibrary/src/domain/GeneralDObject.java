package domain;

import java.io.Serializable;
import java.sql.*;

public abstract class GeneralDObject implements Serializable
{ abstract public String getAtrValue();
  abstract public String setAtrValue();
  abstract public String getClassName();
  abstract public String getWhereCondition();
  abstract public String getNameByColumn(int column);
  abstract public GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
  abstract public int getPrimaryKey();
  abstract public void setID(int id);
  abstract public String poruka1();
  abstract public String poruka2();
  abstract public String poruka3();
  abstract public String poruka4();
  abstract public String poruka5();
  abstract public String poruka6();
  abstract public String poruka7();
  abstract public String poruka8();
  abstract public String poruka9();
  abstract public String porukaX0();
}
