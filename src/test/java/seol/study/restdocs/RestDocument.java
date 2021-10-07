package seol.study.restdocs;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import seol.study.restdocs.common.TestSupport;

public class RestDocument extends TestSupport {

	@Test
	void errorDocument() throws Exception {
		mockMvc.perform(
				post("/test/sample")
						.contentType(MediaType.APPLICATION_JSON)
						.content(readJson("/json/sample/sample-request.json"))
		)
				.andExpect(status().isBadRequest())
				.andDo(
						restDocs.document(
								responseFields(
										fieldWithPath("message").description("에러 메시지"),
										fieldWithPath("status").description("Http Status Code"),
										fieldWithPath("code").description("Error Code"),
										fieldWithPath("timestamp").description("에러 발생 시간"),
										fieldWithPath("errors").description("Error 값 배열 값"),
										fieldWithPath("errors[0].field").description("문제 있는 필드"),
										fieldWithPath("errors[0].value").description("문제가 있는 값"),
										fieldWithPath("errors[0].reason").description("문재가 있는 이유")
								)
						)
				);
	}

	@Test
	void memberStatus() throws Exception {
		mockMvc.perform(
				get("/test/memberStatus")
						.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk());
	}
}
