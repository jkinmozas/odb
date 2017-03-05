/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Joaquin
 */
public class ODBControl {
    
    
    ODB odb = ODBFactory.open("/neodatis.test");
    
    
}
