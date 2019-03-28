package me.namila.RESTSpringTest.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static me.namila.RESTSpringTest.Constants.ApiConstants.DATE_FORMAT;

@Data
class ApiError
{

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;

	private ApiError()
	{
		timestamp = LocalDateTime.now();
	}

	ApiError( HttpStatus status )
	{
		this();
		this.status = status;
	}

	ApiError( HttpStatus status, Throwable ex )
	{
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiError( HttpStatus status, String message, Throwable ex )
	{
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}