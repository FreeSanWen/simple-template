package cn.penguin.provider.web.controller.common;//package cn.penguin.provider.controller.mq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/rocket")
//public class RocketController {
//
//    private final RocketMQTemplate rocketMQTemplate;
//
//    @Autowired
//    public RocketController(RocketMQTemplate rocketMQTemplate) {
//        this.rocketMQTemplate = rocketMQTemplate;
//    }
//
//
//    @GetMapping("/send-message")
//    public String sendMessage(@RequestParam("message") String message){
//        rocketMQTemplate.convertAndSend("test-a", message);
//        return "success";
//    }
//}
