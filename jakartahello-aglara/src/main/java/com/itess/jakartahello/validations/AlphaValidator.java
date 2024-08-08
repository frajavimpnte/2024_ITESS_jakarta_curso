/**
 *ITESS TICS 2024
 * @author Al-Design
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itess.jakartahello.validations;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

@Named
@RequestScoped
public class AlphaValidator {

  public void validateAlpha(FacesContext facesContext, UIComponent uiComponent,
          Object value) throws ValidatorException {
    if (!StringUtils.isAlphaSpace((String) value)) {
      HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
      FacesMessage facesMessage = new FacesMessage(
              htmlInputText.getLabel() + ": only alphabetic characters are allowed.");
      throw new ValidatorException(facesMessage);
    }
  }   
}
