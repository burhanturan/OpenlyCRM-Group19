package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CommentPage {

    public CommentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
