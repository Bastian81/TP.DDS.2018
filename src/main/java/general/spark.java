package general;

import static spark.Spark.*;

public class spark {

    public static void main(String args[]){

        /*get("/gian/*", (req, res) -> {
            return "gian sos: " + req.splat().length;
        });*/
        //delete("/hello", (red, res) -> {
        //    return "gian";
        //});
        path("/api", () -> {
            before("/*", (q, a) -> log.info("Received api call"));
            path("/email", () -> {
                post("/add",       EmailApi.addEmail);
                put("/change",     EmailApi.changeEmail);
                delete("/remove",  EmailApi.deleteEmail);
            });
            path("/username", () -> {
                post("/add",       UserApi.addUsername);
                put("/change",     UserApi.changeUsername);
                delete("/remove",  UserApi.deleteUsername);
            });
        });

    }

}
