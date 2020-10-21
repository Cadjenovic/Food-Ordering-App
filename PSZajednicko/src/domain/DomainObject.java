/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luka
 */

public interface DomainObject {
    public String getTableName();
    public String getAttributeNamesForInsert();
    public String getAttributeValuesForInsert();
    public boolean isAutoincrement();
    public void setObjectId(int id);
    public int getId();
    public List<DomainObject> getList(ResultSet rs);
    public String getWhereConditionOne();
    public DomainObject getOne(ResultSet rs);
    public String getWhereConditionAll();
    public String getJoin();
    public String getUpdate();
}

