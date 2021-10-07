package seol.study.restdocs.member.controller;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static seol.study.restdocs.common.RestDocsConfiguration.field;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import seol.study.restdocs.common.TestSupport;

class MemberApiTest extends TestSupport {

	@Test
	void member_page_test() throws Exception {
		mockMvc.perform(
				get("/api/members")
						.param("size", "10")
						.param("page", "0")
						.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andDo(
						restDocs.document(
								requestParameters(
										parameterWithName("size").optional().description("size"),
										parameterWithName("page").optional().description("page")
								)
						)
				);
	}

	@Test
	void member_get() throws Exception {
		mockMvc.perform(
				get("/api/members/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andDo(
						restDocs.document(
								pathParameters(parameterWithName("id").description("Member Id")),
								responseFields(
										fieldWithPath("id").description("ID"),
										fieldWithPath("name").description("NAME"),
										fieldWithPath("email").description("EMAIL")
								)
						)
				);
	}

	@Test
	void member_create() throws Exception {
		mockMvc.perform(
				post("/api/members")
						.contentType(MediaType.APPLICATION_JSON)
						.content(readJson("/json/member-api/member-create.json"))
		)
				.andExpect(status().isOk())
				.andDo(
						restDocs.document(
								requestFields(
										fieldWithPath("name").description("NAME").attributes(field("length", "10")),
										fieldWithPath("email").description("EMAIL").attributes(field("length", "30"), field("format", "ID@DOMAIN.com")),
										fieldWithPath("status").description("Member Status 코드 참조")
								)
						)
				);
	}

	@Test
	void member_update() throws Exception {
		mockMvc.perform(
				put("/api/members/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(readJson("/json/member-api/member-update.json"))
		)
				.andExpect(status().isOk())
				.andDo(
						restDocs.document(
								pathParameters(
										parameterWithName("id").description("Member Id")
								),
								requestFields(
										fieldWithPath("name").description("name").attributes(field("length", "10"), field("format", "ID@DOMAIN.com"))
								)
						)
				);
	}


	@Test
	void member_create_글자_length_실패() throws Exception {
		mockMvc.perform(
				post("/api/members")
						.contentType(MediaType.APPLICATION_JSON)
						.content(readJson("/json/member-api/member-create-invalid.json"))
		)
				.andExpect(status().isBadRequest());
	}

	@Test
	void member_update_글자_length_실패() throws Exception {
		mockMvc.perform(
				put("/api/members/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(readJson("/json/member-api/member-update-invalid.json"))
		)
				.andExpect(status().isBadRequest());
	}

}
