package com.app.service;

import java.util.ArrayList;

import java.util.List;

import mkcl.os.model.dal.DALHelper;
import mkcl.os.model.dal.ISql;

public class LanguageService {
	
	public String getAllLanguage() {
        ISql icrud = DALHelper.getIsql();
        List<String> arr= new ArrayList<String>();

        try {            
                String str="select languageName from NaturalLanguage";
        arr=icrud.executeQuery(str);
        }catch(Exception e) {
                e.printStackTrace();
        }
      System.out.println(arr.toString());
        return arr.toString();


}

}
