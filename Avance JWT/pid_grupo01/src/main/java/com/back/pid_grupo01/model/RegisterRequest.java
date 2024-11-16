package com.back.pid_grupo01.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private String nombre;
	private String apellido;	
	private String email;
	private String password;
	private Date fecha;
}
