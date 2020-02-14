package br.com.tt.petshop.client;

import br.com.tt.petshop.client.dto.SituacaoCreditoDto;
import br.com.tt.petshop.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Component
public class ApiCreditoClient {

    private static final Logger LOG = LoggerFactory.getLogger(ApiCreditoClient.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    @Value("${app.creditoApi.url}")
    private String urlCredito;


    public SituacaoCreditoDto verificaSituacao(String cpf){
        try {
            String link = "{urlApi}{cpf}";
            return restTemplate.getForObject(link, SituacaoCreditoDto.class, urlCredito,cpf);
        }catch (HttpClientErrorException e){
            LOG.debug("Nome incompleto: {}", e.getMessage());
            throw e;
        }

    }

}
