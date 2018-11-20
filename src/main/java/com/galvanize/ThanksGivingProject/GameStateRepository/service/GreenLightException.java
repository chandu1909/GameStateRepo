package com.galvanize.ThanksGivingProject.GameStateRepository.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class GreenLightException extends Exception{

}
