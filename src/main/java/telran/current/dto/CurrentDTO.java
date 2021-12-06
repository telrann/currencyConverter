package telran.current.dto;

import java.time.LocalDate;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class CurrentDTO {
	boolean success;
	long timestamp;
	String base;
	LocalDate date;
	Map<String, Double> rates;
}
