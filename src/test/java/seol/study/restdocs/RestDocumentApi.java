package seol.study.restdocs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.EnumSet;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seol.study.restdocs.member.entity.MemberStatus;

@RestController
@RequestMapping("/test")
public class RestDocumentApi {

	@Autowired private ObjectMapper objectMapper;

	/**
	 * 에러응답에 대한 문서를 작성하기위해, 에러를 발생시키는 역할을 한다.
	 */
	@PostMapping("/sample")
	public void sample(@RequestBody @Valid SampleRequest dto) {
	}

	@GetMapping("/memberStatus")
	public ArrayNode getMemberStatus() {
		ArrayNode arrayNode = objectMapper.createArrayNode();
		EnumSet<MemberStatus> types = EnumSet.allOf(MemberStatus.class);
		for (final MemberStatus type : types) {
			ObjectNode objectNode = objectMapper.createObjectNode();
			objectNode.put("MemberStatus", type.name());
			objectNode.put("Description", type.getDescription());
			arrayNode.add(objectNode);
		}
		return arrayNode;
	}

	public static class SampleRequest implements Serializable {

		@NotEmpty
		private String name;

		@Email
		private String email;

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}
	}

}
