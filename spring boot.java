

//Spring Boot attaches a Tomcat/Jetty server with the compiled Jar using Maven/Gradle. 

//Spring Boot provides cloud support for conf

// good links
Spring Boot Docs - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
Spring Boot API - https://docs.spring.io/spring-boot/docs/current/api/
Spring IO Platform - http://spring.io/projects
Spring IO Website: http://www.spring.io
Spring Projects: http://spring.io/projects
Spring Guides: http://spring.io/guides
Spring Document: http://spring.io/guides


//three types of injection
1- property based injection

2- setter based injection

3- constructor based injection


//YAML is easier form of json

// we can define property in the application properities file
// then we can inject it to the application
//in properties file
pageContorller.msg = my good message

// in the application

@Value("${pageCOntroller.msg}")
private String PageCOntrollerMsg;

// this will inject the value in the properties file to the property in the app

// in resources we can create application.yml
// we can add our application properities in this file by YAML language


// we can add random values to our appliacation properities
page.msg = ${random.int}

// to enable fast properties injectsion
//1. in the main class add
@EnableConfiguration

//2. in the target class
@Configuration( prefix = "MyConfig")

//3. in the applications.properties
MyConfig:
	name : value
	birth : value
	address : value


	// it's cool and will map application properities to class properities
	// even each of them written in camelCase or in dash-names

// profiles makes certain configuration available in certain environments

// to use profiles 
// in the application.properities file we add
spring.profile.active = anyprofilename1 , anyprofilename2

// we can create different application.properities file based on environment we are in
// we should call it   applicaion-anyprofilename1.properities

// or we can add it in the .yml file with the
spring:
	profile: anyprofilename1
		properitesname : value
---
spring:
	profile: anyprofilename2
		properitesname : value


// we can also define versions of method to be used by beans
// in different environents
@profile("anyprofilename1")
public void myMethod () {}

@profile("anyprofilename2")
public void myMethod () {}


//auto configuration
@SpringBootApplication contains inside it @EnableAutoConfiguration()


// we can exclude some file from having auto configuration
@EnableAutoConfiguration(exclude = 'className.class')


@Controller
// defines class to handle requests

@RequestMapping("/")
//to define request type and we can define base of content in it a

@RestController
//has alot of steroe type annotations

@SpringBootApplication
// should be in the main application class


// we created anther three packages --> service , config and controller

//we can get webjars gradle compile code from webjars website
// we can also user bower or grunt package manager to user this jars

// AOP composed from pointcuts and advices
@Aspect // is put on class to define it 
@pointcut( ... ) // defining pointcut 
@Before() , @After() // any type of advices



// when using template engine like thymeleaf while development we shout close caching 
spring.thymeleaf.cache = false

// to get text variable of thymeleaf in html file
<title th:text="${varName}"></title>
th:href="@{...}" //this wil add url


// to loop over structure in thymeleaf
th:each="iterationVar : ${strucName}"


// GSP = Groovy Server Pages
//using GSP we have many tags
<g:tagName>
</g:tagName>

//like
<g:each in {} >
</each>

//or
<g:render template="">
</g:render>


// internationaliztion
// we make files messages-fr , message-en
// this in the application properities we can add
spring.mvc.locale = fr



// erorr handling in spring boot
// we have many types of errors
// we can handle any of them if we want


// at default error.html is laoded when errors happen
// we can use custom error handling
@RequestMapping("/error")
//or
@RequestMapping("/404")

@RequestMapping("/get/{slug}") // slug here is a path variable
public String getPost ( @PathVariable(value = "slug") String slug)
{
	return "post";
}

// to handle exceptions 
@ExceptionHandler(Exception.class)

// to have a good access in our sts project
// select from containter in sts project
web , thymeleaf , H2 from database , jpa from data

//we create packages in our project
service , controller , entity , DAO // we can also have config package for @Configuration

//DAO or can be called repo
class that will give us data from any database we want
this class may contains methods like getStudent and setStudent or addStudent
this can contain classes like StudentDAO
can contain Map of the entity class
uses @Repository'
@Repository is child of @Component

//to use actual database with spring
we use Refractor > Extract > Interface
//then
we select methods in DAO to this window
then select all to replace it with the old class
//then
we create to represent our database and will implement the DAO class Interface
in this calss we can create connection and implement interface methods
// we can use @Qualifier to avoid misuse of @AutoWired
// Qualifier must match in the class and it's calls

//entity or can be said model or can be called domain
contains entities of our projects
may contain classes like Student
this class can contain data members of student and methods for him

static {

}
It's a static initializer. It's executed when the class is loaded 
(or initialized, to be precise, but you usually don't notice the difference).

// for specific database like H2
can has @Entiiy above it 
the main elements in this class can have @Id and @GeneratedValue
one some other collection we can use @OneToMany ( mappedBy = "authorClass")


//service
it may contains classes like StudentService
in it we create instance from Student DAO
all bussiness logic will be in it
uses @service

// controller 
it may contain classes like StudentController
it will handle all http requests
it will have instance from StudentService and uses @Autowired
uses @RestController or @PostMapping
can have @RequestMapping("/") on the class
methods in this calss can have @RequestMapping(value="" , method=RequestMethod.GET)
if @RequestMapping(value="" , method=RequestMethod.GET) contains value = "/{id}""

id here is variable in the path

//example
@RequestMapping(value="/{id}" , method=RequestMethod.GET)
public String getSudetnt( @PathVariable int id)
{
	// use thsi id 
}

// RequestMehod can be GET , POST , DELETE , PUT , OPTIONS
// to use RequestMethod.Put we need to add
@RequestBody // with it so we can index input to update

//example
@RequestMapping(method=RequestMethod.PUT)
public String getSudetnt( @RequestBOdy Student student)
//we can tell method that we will send json
//public String getSudetnt( @RequestBOdy Student student , consume = Media.APPLICAOIN_JSON_VALUE)
{
	// update this student
}

//Main
it will contain main function
uses @SpringBootApplication
springApplication.run(Main.clas, args);


// we use DI to reduce usage of new as possilbe 
// so we can have decoupled system

// to make project easy to use and install
// go to Mavenproject > life cycle
// select install
// then in target file we will have spring+SNAPSHOt.jar file
// we can run this app from the terminal
java -jar app_path

