package com.backend.core.users.application.dtos.users;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.backend.core.users.application.utils.RegexConstant;
import com.backend.core.users.domain.exception.BadRequestException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    
    

    private String name;
    private String lastname;
    private String document;
    private String phone;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String roleName;


    public void validate() {
        
        if( name == null || name.isEmpty() ) throw new BadRequestException(400, "El nombre es obligatorio.");
        if( lastname == null || lastname.isEmpty() ) throw new BadRequestException(400, "El apellido es obligatorio.");
        if( password == null || password.isEmpty() ) throw new BadRequestException(400, "La contraseña es obligatoria.");
        
        if( email == null || !email.matches(RegexConstant.patternEmail) ) throw new BadRequestException(400, "El correo no es válido.");
        if( phone == null || !phone.matches(RegexConstant.patternPhone) ) throw new BadRequestException(400, "El número de teléfono no es válido.");
        if( document == null || !document.matches(RegexConstant.patternOnlyNumber) ) throw new BadRequestException(400, "El número de documento no es válido.");
        if( birthDate == null || ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < 18 )  throw new BadRequestException(400, "El usuario debe ser mayor de edad.");

    }


}
