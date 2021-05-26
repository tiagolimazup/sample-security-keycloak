package br.com.zup.edu.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJnVGhLSTc3WXFTZXBCcm1lLVA1OV94OEZrTVR0UUdHNHVGN1Jjb1E3S0NFIn0.eyJleHAiOjE2MjE5NzY1MTIsImlhdCI6MTYyMTk3NjIxMiwianRpIjoiYmMxMjlmNmQtZTlkMi00MDM3LTk0ZGYtYjhiOWI2MTU4YWM2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDoxODA4MC9hdXRoL3JlYWxtcy9vcmFuZ2UtdGFsZW50cy00Iiwic3ViIjoiYjhjOWI1ZTktMzM3Ni00MTc2LWE2MzYtMWUyNTBlM2Y3YzliIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoic2FtcGxlLXNlYyIsInNlc3Npb25fc3RhdGUiOiJmOWM1ZjExMy1kZTRhLTQ1ZDEtYThlYS05NWMwNjYzZmVjOGIiLCJhY3IiOiIxIiwic2NvcGUiOiJhZGRyZXNzIG5vc3NvLWVzY29wbzp3cml0ZSBub3Nzby1lc2NvcG86cmVhZCIsImFkZHJlc3MiOnt9fQ.i8hPUCgfgcYHx8ITrUNxR35q4eI_65Wm6XbMZPxlbzmpVo8nDIN-hy7Gzt-zPkdS4J0C6vPDgWKv71WKWFPTjObM0zmY3PxjJ-JZbl-3Kxfzu6rUytrx0ZWbR6TiwRjttaQotBmVUXTgebEtjsNXs18TYUK24uZqeUqdhkHnt0a4lGXa0AlhdkdAseBv8ObslFB33ikofgE43Uu63UAYZ5yR_EEvZZDKaYcUW1NhmtcF84AYbAOaqKky9IOiyyJAdGYKSIXt-d0csZjezQBiwhlVbxNbDyL_5nqqLRgPWNfGeUBlpEqTNC388tW6_JrWQeWgT23nRMcSjvWoI7WraA";
        mockMvc.perform(get("/hello")
//                    .header("Authorization", "Bearer " + jwt))
                            .with(jwt().authorities(new SimpleGrantedAuthority("SCOPE_read"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, tiago.lima"));
    }
}
