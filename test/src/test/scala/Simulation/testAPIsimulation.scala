package Simulation

//Import required object and references

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

//Extend Testclass with Simulation class

class testAPIsimulation extends Simulation{


  //Step1: Define a common http protocol config
  private val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7,ru;q=0.6,nl;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")

  private val headers_0 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="96", "Google Chrome";v="96""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-ch-ua-platform" -> "Windows"
  )
  private val scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .get("/DevOpsProject_Alon_Adi_Daniel/?limit=15")
        .headers(headers_0)
    )
  setUp(scn.inject(rampUsersPerSec(1).to(50).during(10.seconds),
    constantUsersPerSec(50) during (40.seconds),
    rampUsersPerSec(50).to(1).during(10.seconds))).protocols(httpProtocol)


}