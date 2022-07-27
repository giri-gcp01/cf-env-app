package tech.gcplearnng.cf;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvResource {
	
	@GetMapping("/env")
	public String hello() {
		
		String bgColor = System.getenv("BGCOLOR")!=null?System.getenv("BGCOLOR"):"white";
		
		Map<String, String> env = System.getenv();
		StringBuilder sb = new StringBuilder();
		sb.append("<HTML><HEAD>");
		sb.append("<STYLE>\r\n"
				+ "table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n"
				+ "}\r\n"
				+ "</STYLE>\r\n"
				+ "</HEAD>");
		sb.append("<BODY").append(" bgcolor=").append(bgColor+">");
		sb.append("<H1>Environment variables</H1>");
		sb.append("<BR>");
		sb.append("<TABLE style=\"width:100% border:1px\">");
		for (String envName : env.keySet()) {
			sb.append("<TR>");
		    sb.append("<TD>").append(envName).append("</TD>");
		    sb.append("<TD>").append(env.get(envName)).append("</TD>");
		    sb.append("</TR>");
		}
		sb.append("</TABLE>");
		sb.append("</BODY></HTML>");
		return sb.toString();
	}
	
	@GetMapping("/health")
	public ResponseEntity<String> health() {
		System.out.println("**********Invoking Health Endpoint************");
		 return  new ResponseEntity("Service Heathy!!!",HttpStatus.OK);
	}

}
