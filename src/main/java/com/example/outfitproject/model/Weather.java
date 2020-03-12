package com.example.outfitproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

	private static final long serialVersionUID = 7406210628182440902L;

	private String weatherDescription;
	private String name;
	private double temperature;

	//private double lon;
	//private double lat;

	@Bean
	public Weather weather() {
		return new Weather();
	}

	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(Weather weather) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		String desc = Arrays.stream(weatherDescription.split("\\s+"))
				.map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
				.collect(Collectors.joining(" "));
		this.weatherDescription = desc;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}

	public String getTemperature() {
		return getTemperatureDigitFormatting(temperature) + " °F";
	}

	public String getTemp() {
		return getTemperatureDigitFormatting(temperature);
	}

	public void setTemperature(double temperatureKelvin) {
		this.temperature = temperatureKelvin;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		double kelvinTemp = Double.parseDouble(main.get("temp").toString());
		setTemperature(celsiusToFahrenheit(kelvinToCelsius(kelvinTemp)));
	}

	protected double celsiusToFahrenheit(double temperature) {
		return  (temperature * 9/5.0) +32;
	}

	protected double kelvinToCelsius(double temperatureKelvin) {
		return temperatureKelvin - 273.15;
	}

	protected String getTemperatureDigitFormatting(double temperature) {
		return String.format("%4.2f", temperature);
	}

	/*@JsonProperty("lon")
	public double getLon() {
		return lon;
	}

	@JsonProperty("lon")
	public void setLon(double lon) {
		this.lon = lon;
	}

	@JsonProperty("coord")
	public void setCoord(Map<String, Object> coord) {
		setLon((double) coord.get("lon"));
		setLat((double) coord.get("lat"));

		public double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}


	}*/
}