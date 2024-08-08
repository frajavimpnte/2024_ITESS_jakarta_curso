/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itess.jakartahello.validations;

/**
 *
 * @author Al-Design
 */
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

@FacesValidator(value = "emailValidator")
public class EmailAddressValidator implements Validator {
  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent,
          Object value) throws ValidatorException {

    EmailValidator emailValidator = EmailValidator.getInstance();
    HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
    String emailAddress = (String) value;
    if (!StringUtils.isEmpty(emailAddress)) {
      if (!emailValidator.isValid(emailAddress)) {
        FacesMessage facesMessage = new FacesMessage(
                htmlInputText.getLabel() + ": email format is not valid");
        throw new ValidatorException(facesMessage);
      }
    }
  }
}