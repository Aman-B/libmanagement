/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmangaement;

import libmangaement.search;
/**
 *
 * @author hp
 */
public class issue {
    
    public boolean issueb(String book)
    {
        search s = new search();
        if(s.searchb(book)!=-1)
        {
            return true;
        }
        else{
            return false;
        }
    };
    
    public boolean issues (String book)
    {
        search s=new search();
        if(s.issued(book)){
            return true;
        }
        else
        {
            return false;
        }
    };
    
    public boolean returns (String book)
    {
        search s = new search();
        if(s.returned(book))
        {
            return true;
        }
        else
            return false;
    }
    
    
}
