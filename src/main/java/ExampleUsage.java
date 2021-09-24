import com.Application;
import com.Customer;
import org.drools.core.beliefsystem.jtms.JTMSBeliefSetImpl;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNMetadata;
import org.kie.dmn.api.core.DMNResult;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.dmn.DMNModelInfo;
import org.kie.server.api.model.dmn.DMNModelInfoList;
import org.kie.server.client.DMNServicesClient;
import org.kie.server.client.ProcessServicesClient;
import org.redhat.rhpam.tests.AbstractKieServerConnector;
import org.redhat.rhpam.tests.ISOExpressionHelper;
import org.redhat.rhpam.tests.NotificationConfiguration;
import org.redhat.rhpam.tests.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ExampleUsage extends AbstractKieServerConnector {

    private static final String CONTAINER_ID = "DMNTest";
    private static final String ALIAS = "MigrationSample"; //com.myspace:MigrationExample:1.0.2-SNAPSHOT
    private static final String PROCESS_ID = "MigrationExample.MigrateMe";
    private static final String NAMESPACE = "https://kiegroup.org/dmn/_EB218E04-A7FF-4D22-B5BC-5614B888F96C";
    private static final String MODEL = "SettlementDate";
    private static final String USER = "anton";
    private static final String VAR_NAME = "delayCompleted";
    private static final Long DELAY = 12000L;
    private static final Logger log = LoggerFactory.getLogger(ExampleUsage.class);

    public static void main(String[] args) {
        ExampleUsage client = new ExampleUsage();

// you can start the process like this

//        ProcessServicesClient pClient = client.getProcessClient();
//        pClient.startProcess(ALIAS,PROCESS_ID);

        KieCommands commands = KieServices.Factory.get().getCommands();


        DMNServicesClient dmnClient = client.getDMNClient();
        DMNContext context = dmnClient.newContext();
        Statement statement = new Statement();
        statement.setAccountingType("A");
        context.set("statement",statement);
        context.set("todaysDate", LocalDate.now());
        ServiceResponse<DMNResult> result = dmnClient.evaluateAll(CONTAINER_ID, NAMESPACE,MODEL, context);
        DMNResult actualResult = result.getResult();
        actualResult.getDecisionResults().forEach(r -> {
            log.info("result name {}, result value {}", r.getDecisionName(), r.getResult());
        });


//
//        ServiceResponse<DMNModelInfoList> models = dmnClient.getModels(CONTAINER_ID);
//        List<DMNModelInfo> modelsUnwrapped = models.getResult().getModels();
//        modelsUnwrapped.forEach(m -> {
//            m.getDecisions().forEach(d -> {
//                // every decision of every model in a kjar
//            });
//        });
//
//        DMNContext context = dmnClient.newContext();
//        context.set("date","2021-08-27");
//       // context.set("date","27-08-2021");
//        ServiceResponse<DMNResult> result = dmnClient.evaluateAll(CONTAINER_ID, NAMESPACE,MODEL, context);
//
//        DMNResult actualResult = result.getResult();
//        actualResult.getDecisionResults().forEach(r -> {
//            log.info("result name {}, result value {}", r.getDecisionName(), r.getResult());
//        });

//        NotificationConfiguration configuration = new NotificationConfiguration();
//        configuration.setInitialDelayUnit("SECONDS");
//        configuration.setInitialDelayValue("5");
//        configuration.setNumberOfRepetitions("10");
//        configuration.setSubsequentDelayUnit("SECONDS");
//        configuration.setSubsequentDelayValue("3");
//        configuration.setZoneId(ZoneId.systemDefault());
//
//       String iso = ISOExpressionHelper.generateISOExpression(configuration);
//       log.info("iso expression {}", iso);
//
//
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("actorHT1","anton1");
//        params.put("actorHT3","iDontExist");
//        params.put("actorHT4","anton2");
//        params.put("groupHT2","kie-server");
//        params.put("HT1SLA","PT5S");
//        params.put("HT2Notification",iso);
//
//        Arrays.asList(1);
//
//
//
//
//        long pid = client.getProcessClient().startProcess(CONTAINER_ID,PROCESS_ID,params);
//        log.info("Process with pid {} started", pid);

    }
}
