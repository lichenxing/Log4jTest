* LogTest.java为一个独立的日志例子 ，其结合使用commons-logging.jar和log4j-1.2.17.jar
* MyApp.java和Bar.java为一个独立的日志例子，其只使用了log4j-1.2.17.jar

结合使用commons-logging.jar和log4j-1.2.17.jar的方式使用更加便捷。

Log4j

一、Log4j由三个重要的组件构成：日志信息的优先级，日志信息的输出目的地，日志信息的输出格式。日志信息的优先级从高到低有ERROR、WARN、
    INFO、DEBUG，分别用来指定这条日志信息的重要程度；日志信息的输出目的地指定了日志将打印到控制台还是文件中；而输出格式则控制了日志
    信息的显示内容。
二、配置文件 
其实您也可以完全不使用配置文件，而是在代码中配置Log4j环境。但是，使用配置文件将使您的应用程序更加灵活。 
Log4j支持两种配置文件格式，一种是XML格式的文件，一种是properties格式的文件。下面我们介绍使用properties格式做为配置文件的方法： 
示例： 
log4j.rootLogger=INFO, A1 
log4j.appender.A1=org.apache.log4j.ConsoleAppender 
log4j.appender.A1.layout=org.apache.log4j.PatternLayout 
log4j.appender.A1.layout.ConversionPattern=%-4r %-5p [%t] %37c %3x - %m%n 

1. 配置根Logger，其语法为： 
log4j.rootLogger = [ level ] , appenderName, appenderName, … 
其中，level 是日志记录的优先级，分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者您定义的级别。Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG。通过在这里定义的级别，您可以控制到应用程序中相应级别的日志信息的开关。比如在这里定义了INFO级别，则应用程序中所有DEBUG级别的日志信息将不被打印出来。 
appenderName就是指定日志信息输出到哪个地方。您可以同时指定多个输出目的地。 

2. 配置日志信息输出目的地Appender，其语法为： 
log4j.appender.appenderName = fully.qualified.name.of.appender.class 
log4j.appender.appenderName.option1 = value1 
… 
log4j.appender.appenderName.option = valueN 
其中，Log4j提供的appender有以下几种： 
org.apache.log4j.ConsoleAppender（控制台）， 
org.apache.log4j.FileAppender（文件）， 
org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）， 
org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）， 
org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方） 
(1).ConsoleAppender选项 
Threshold=WARN:指定日志消息的输出最低层次。 
ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。 
Target=System.err：默认情况下是：System.out,指定输出控制台 
(2).FileAppender 选项 
Threshold=WARN:指定日志消息的输出最低层次。 
ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。 
File=mylog.txt:指定消息输出到mylog.txt文件。 
Append=false:默认值是true,即将消息增加到指定文件中，false指将消息覆盖指定的文件内容。 
(3).DailyRollingFileAppender 选项 
Threshold=WARN:指定日志消息的输出最低层次。 
ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。 
File=mylog.txt:指定消息输出到mylog.txt文件。 
Append=false:默认值是true,即将消息增加到指定文件中，false指将消息覆盖指定的文件内容。 
DatePattern=’.'yyyy-ww:每周滚动一次文件，即每周产生一个新的文件。当然也可以指定按月、周、天、时和分。即对应的格式如下： 
  1)’.'yyyy-MM: 每月 
  2)’.'yyyy-ww: 每周 
  3)’.'yyyy-MM-dd: 每天 
  4)’.'yyyy-MM-dd-a: 每天两次 
  5)’.'yyyy-MM-dd-HH: 每小时 
  6)’.'yyyy-MM-dd-HH-mm: 每分钟 
(4).RollingFileAppender 选项 
Threshold=WARN:指定日志消息的输出最低层次。 
ImmediateFlush=true:默认值是true,意谓着所有的消息都会被立即输出。 
File=mylog.txt:指定消息输出到mylog.txt文件。 
Append=false:默认值是true,即将消息增加到指定文件中，false指将消息覆盖指定的文件内容。 
MaxFileSize=100KB: 后缀可以是KB, MB 或者是 GB. 在日志文件到达该大小时，将会自动滚动，即将原来的内容移到mylog.log.1文件。 
MaxBackupIndex=2:指定可以产生的滚动文件的最大数。 

3. 配置日志信息的布局，其语法为： 
log4j.appender.appenderName.layout = fully.qualified.name.of.layout.class 
log4j.appender.appenderName.layout.option1 = value1 
… 
log4j.appender.appenderName.layout.option = valueN 
其中，Log4j提供的layout有以下几种： 
org.apache.log4j.HTMLLayout（以HTML表格形式布局）， 
org.apache.log4j.PatternLayout（可以灵活地指定布局模式）， 
org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）， 
org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息） 

4、输出格式设置 
在配置文件中可以通过log4j.appender.A1.layout.ConversionPattern设置日志输出格式。 
参数： 
%p: 输出日志信息优先级，即DEBUG，INFO，WARN，ERROR，FATAL, 
%d: 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921 
%r: 输出自应用启动到输出该log信息耗费的毫秒数 
%c: 输出日志信息所属的类目，通常就是所在类的全名 
%t: 输出产生该日志事件的线程名 
%l: 输出日志事件的发生位置，相当于%C.%M(%F:%L)的组合,包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java:10) 
%x: 输出和当前线程相关联的NDC(嵌套诊断环境),尤其用到像java servlets这样的多客户多线程的应用中。 
%%: 输出一个”%”字符 
%F: 输出日志消息产生时所在的文件名称 
%L: 输出代码中的行号 
%m: 输出代码中指定的消息,产生的日志具体信息 
%n: 输出一个回车换行符，Windows平台为”\r\n”，Unix平台为”\n”输出日志信息换行 
可以在%与模式字符之间加上修饰符来控制其最小宽度、最大宽度、和文本的对齐方式。如： 
1)%20c：指定输出category的名称，最小的宽度是20，如果category的名称小于20的话，默认的情况下右对齐。 
2)%-20c:指定输出category的名称，最小的宽度是20，如果category的名称小于20的话，”-”号指定左对齐。 
3)%.30c:指定输出category的名称，最大的宽度是30，如果category的名称大于30的话，就会将左边多出的字符截掉，但小于30的话也不会有空格。 
4)%20.30c:如果category的名称小于20就补空格，并且右对齐，如果其名称长于30字符，就从左边交远销出的字符截掉。 

三、在程序中的使用 
在程序中使用Log4j之前，首先要将commons-logging.jar和logging-log4j-1.2.9.jar导入到classpath中，并将log4j.properties放于src根目录中。接下来就可以使用了。 

1.得到记录器 
使用Log4j，第一步就是获取日志记录器，这个记录器将负责控制日志信息。其语法为： 
public static Logger getLogger( String name)， 
通过指定的名字获得记录器，如果必要的话，则为这个名字创建一个新的记录器。Name一般取本类的名字，比如： 
static Logger logger = Logger.getLogger ( ServerWithLog4j.class.getName () ) ; 
注：推荐使用commons-logging结合log4j进行日志记录 
private static Log logger = LogFactory.getLog(Yourclass.class); 

2.插入记录信息（格式化日志信息） 
当上两个必要步骤执行完毕，您就可以轻松地使用不同优先级别的日志记录语句插入到您想记录日志的任何地方，其语法如下： 
Logger.debug ( Object message ) ; 
Logger.info ( Object message ) ; 
Logger.warn ( Object message ) ; 
Logger.error ( Object message ) ; 

四、Log4j比较全面的配置 
LOG4J的配置之简单使它遍及于越来越多的应用中了：Log4J配置文件实现了输出到控制台、文件、回滚文件、发送日志邮件、输出到数据库日志表、自定义标签等全套功能。择其一二使用就够用了。

log4j.rootLogger=DEBUG,CONSOLE,A1,im
log4j.addivity.org.apache=true
# 应用于控制台
log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender
log4j.appender.Threshold=DEBUG
log4j.appender.CONSOLE.Target=System.out
log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
log4j.appender.CONSOLE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
#log4j.appender.CONSOLE.layout.ConversionPattern=[start]%d{DATE}[DATE]%n%p[PRIORITY]%n%x[NDC]%n%t[thread] n%c[CATEGORY]%n%m[MESSAGE]%n%n
#应用于文件
log4j.appender.FILE=org.apache.log4j.FileAppender
log4j.appender.FILE.File=file.log
log4j.appender.FILE.Append=false
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
# Use this layout for LogFactor 5 analysis
# 应用于文件回滚
log4j.appender.ROLLING_FILE=org.apache.log4j.RollingFileAppender
log4j.appender.ROLLING_FILE.Threshold=ERROR
log4j.appender.ROLLING_FILE.File=rolling.log //文件位置,也可以用变量${java.home}、rolling.log
log4j.appender.ROLLING_FILE.Append=true //true:添加 false:覆盖
log4j.appender.ROLLING_FILE.MaxFileSize=10KB //文件最大尺寸
log4j.appender.ROLLING_FILE.MaxBackupIndex=1 //备份数
log4j.appender.ROLLING_FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.ROLLING_FILE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

#应用于socket
log4j.appender.SOCKET=org.apache.log4j.RollingFileAppender
log4j.appender.SOCKET.RemoteHost=localhost
log4j.appender.SOCKET.Port=5001
log4j.appender.SOCKET.LocationInfo=true
# Set up for Log Facter 5
log4j.appender.SOCKET.layout=org.apache.log4j.PatternLayout
log4j.appender.SOCET.layout.ConversionPattern=[start]%d{DATE}[DATE]%n%p[PRIORITY]%n%x[NDC]%n%t[thread]%n%c[CATEGORY]%n%m[MESSAGE]%n%n

# Log Factor 5 Appender
log4j.appender.LF5_APPENDER=org.apache.log4j.lf5.LF5Appender
log4j.appender.LF5_APPENDER.MaxNumberOfRecords=2000
# 发送日志给邮件
log4j.appender.MAIL=org.apache.log4j.net.SMTPAppender
log4j.appender.MAIL.Threshold=FATAL
log4j.appender.MAIL.BufferSize=10
log4j.appender.MAIL.From=web@www.wuset.com
log4j.appender.MAIL.SMTPHost=www.wusetu.com
log4j.appender.MAIL.Subject=Log4J Message
log4j.appender.MAIL.To=web@www.wusetu.com
log4j.appender.MAIL.layout=org.apache.log4j.PatternLayout
log4j.appender.MAIL.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
# 用于数据库
log4j.appender.DATABASE=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.DATABASE.URL=jdbc:mysql://localhost:3306/test
log4j.appender.DATABASE.driver=com.mysql.jdbc.Driver
log4j.appender.DATABASE.user=root
log4j.appender.DATABASE.password=
log4j.appender.DATABASE.sql=INSERT INTO LOG4J (Message) VALUES (’[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n’)
log4j.appender.DATABASE.layout=org.apache.log4j.PatternLayout
log4j.appender.DATABASE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

log4j.appender.A1=org.apache.log4j.DailyRollingFileAppender
log4j.appender.A1.File=SampleMessages.log4j
log4j.appender.A1.DatePattern=yyyyMMdd-HH’.log4j’
log4j.appender.A1.layout=org.apache.log4j.xml.XMLLayout
#自定义Appender
log4j.appender.im = net.cybercorlin.util.logger.appender.IMAppender
log4j.appender.im.host = mail.cybercorlin.net
log4j.appender.im.username = username
log4j.appender.im.password = password
log4j.appender.im.recipient = corlin@cybercorlin.net
log4j.appender.im.layout=org.apache.log4j.PatternLayout
log4j.appender.im.layout.ConversionPattern =[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n



