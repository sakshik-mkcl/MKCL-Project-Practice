package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.entity.City;
import com.app.entity.Country;
import com.app.entity.State;

@Repository
public class CountryStateDao {
	
	Connection con;
    PreparedStatement pst;
    String query;
    ResultSet rs;
    
    public CountryStateDao(Connection con) {
        this.con = con;
    }
    
    public List<Country> getCountry(){
        List<Country> list  = new ArrayList<Country>();
        try{
            query = "select * from country";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                list.add(country);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    
    public List<State> getState(int countryId){
        List<State> list = new ArrayList<State>();
        try{
            query = "select * from state where cid=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, countryId);
            rs = pst.executeQuery();
            while(rs.next()){
                State state = new State();
                state.setId(rs.getInt("id"));
                state.setCountryId(rs.getInt("cid"));
                state.setName(rs.getString("name"));
                list.add(state);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } 
        return list;
    }
    
    public List<City> getCity(int stateId){
        List<City> list = new ArrayList<City>();
        try{
            query = "select * from city where sid=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, stateId);
            rs = pst.executeQuery();
            while(rs.next()){
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountryId(rs.getInt("cid"));
                city.setStateId(rs.getInt("sid"));
                city.setName(rs.getString("name"));
                list.add(city);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
