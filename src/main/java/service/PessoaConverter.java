package service;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.springframework.web.jsf.FacesContextUtils;

import model.Pessoa;

@Named
@ApplicationScoped
@FacesConverter(value = "pessoaConverter", managed = true)
public class PessoaConverter implements Converter<Pessoa> {

    @Override
    public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        PessoaService pessoaService = FacesContextUtils
                .getWebApplicationContext(context)
                .getBean(PessoaService.class);
        return pessoaService.findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Pessoa pessoa) {
        if (pessoa == null || pessoa.getId() == null) {
            return "";
        }
        return pessoa.getId().toString();
    }
}