package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ourbusinessproject.Services.InitializationService;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }

    public void setInitializationService(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try{
            this.getInitializationService().initProjects();
            this.getInitializationService().initPartnerships();
        }catch (Exception e){
        }
    }
}
