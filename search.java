/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmangaement;

/**
 *
 * @author hp
 */
public class search {
    int size=5;
    String  books[] = {"Book1", "Book2", "Book3","Book4","Book5"};
     int flag=-1;
    public int searchb(String book)
    {
       
        
        for(int i=0;i<size;i++)
        {
            if(books[i].equalsIgnoreCase(book))
                flag=i;
        }
        
        return flag;
        
    };
    
    
    public boolean issued(String book)
            {
                 for (int k = flag; k<size-1;k++)
                 {
                     books[k]=books[k+1];
                 }      
                 size--;
                 return true;
    };
    
    
    public boolean returned(String book)
    {
        books[size++]=book;
        return true;
    };
    
    
    
}

