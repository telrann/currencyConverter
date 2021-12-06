package telran.current.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.current.dto.CurrentDTO;

public class CurrentAppl {

	public static void main(String[] args) throws URISyntaxException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("From current:");
		String fc = br.readLine();
		
		System.out.println("To current:");
		String tc = br.readLine();
		System.out.println("Quantity:");
		int q = Integer.parseInt(br.readLine());
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://data.fixer.io/api/latest")
					.queryParam("access", "00c022c37d03deac05b5c39424734064")
					.queryParam("symbols", "USD,EUR,BTC");
				
		RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET,
				new URI("http://data.fixer.io/api/latest?access_key=00c022c37d03deac05b5c39424734064&symbols=USD,EUR,BTC"));
		
		ResponseEntity<CurrentDTO> responseEntity = restTemplate.exchange(requestEntity, CurrentDTO.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getHeaders().get("Content-Type"));
		System.out.println(responseEntity.getBody());
		
		Map<String, Double> rates = responseEntity.getBody().getRates();
		
		double res = q / rates.get(fc) * rates.get(tc);
		
		System.out.println(res);
		
		

	}

}
