* LogTest.javaΪһ����������־���� ������ʹ��commons-logging.jar��log4j-1.2.17.jar
* MyApp.java��Bar.javaΪһ����������־���ӣ���ֻʹ����log4j-1.2.17.jar

���ʹ��commons-logging.jar��log4j-1.2.17.jar�ķ�ʽʹ�ø��ӱ�ݡ�

Log4j

һ��Log4j��������Ҫ��������ɣ���־��Ϣ�����ȼ�����־��Ϣ�����Ŀ�ĵأ���־��Ϣ�������ʽ����־��Ϣ�����ȼ��Ӹߵ�����ERROR��WARN��
    INFO��DEBUG���ֱ�����ָ��������־��Ϣ����Ҫ�̶ȣ���־��Ϣ�����Ŀ�ĵ�ָ������־����ӡ������̨�����ļ��У��������ʽ���������־
    ��Ϣ����ʾ���ݡ�
���������ļ� 
��ʵ��Ҳ������ȫ��ʹ�������ļ��������ڴ���������Log4j���������ǣ�ʹ�������ļ���ʹ����Ӧ�ó�������� 
Log4j֧�����������ļ���ʽ��һ����XML��ʽ���ļ���һ����properties��ʽ���ļ����������ǽ���ʹ��properties��ʽ��Ϊ�����ļ��ķ����� 
ʾ���� 
log4j.rootLogger=INFO, A1 
log4j.appender.A1=org.apache.log4j.ConsoleAppender 
log4j.appender.A1.layout=org.apache.log4j.PatternLayout 
log4j.appender.A1.layout.ConversionPattern=%-4r %-5p [%t] %37c %3x - %m%n 

1. ���ø�Logger�����﷨Ϊ�� 
log4j.rootLogger = [ level ] , appenderName, appenderName, �� 
���У�level ����־��¼�����ȼ�����ΪOFF��FATAL��ERROR��WARN��INFO��DEBUG��ALL����������ļ���Log4j����ֻʹ���ĸ��������ȼ��Ӹߵ��ͷֱ���ERROR��WARN��INFO��DEBUG��ͨ�������ﶨ��ļ��������Կ��Ƶ�Ӧ�ó�������Ӧ�������־��Ϣ�Ŀ��ء����������ﶨ����INFO������Ӧ�ó���������DEBUG�������־��Ϣ��������ӡ������ 
appenderName����ָ����־��Ϣ������ĸ��ط���������ͬʱָ��������Ŀ�ĵء� 

2. ������־��Ϣ���Ŀ�ĵ�Appender�����﷨Ϊ�� 
log4j.appender.appenderName = fully.qualified.name.of.appender.class 
log4j.appender.appenderName.option1 = value1 
�� 
log4j.appender.appenderName.option = valueN 
���У�Log4j�ṩ��appender�����¼��֣� 
org.apache.log4j.ConsoleAppender������̨���� 
org.apache.log4j.FileAppender���ļ����� 
org.apache.log4j.DailyRollingFileAppender��ÿ�����һ����־�ļ����� 
org.apache.log4j.RollingFileAppender���ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ����� 
org.apache.log4j.WriterAppender������־��Ϣ������ʽ���͵�����ָ���ĵط��� 
(1).ConsoleAppenderѡ�� 
Threshold=WARN:ָ����־��Ϣ�������Ͳ�Ρ� 
ImmediateFlush=true:Ĭ��ֵ��true,��ν�����е���Ϣ���ᱻ��������� 
Target=System.err��Ĭ��������ǣ�System.out,ָ���������̨ 
(2).FileAppender ѡ�� 
Threshold=WARN:ָ����־��Ϣ�������Ͳ�Ρ� 
ImmediateFlush=true:Ĭ��ֵ��true,��ν�����е���Ϣ���ᱻ��������� 
File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ����ݡ� 
(3).DailyRollingFileAppender ѡ�� 
Threshold=WARN:ָ����־��Ϣ�������Ͳ�Ρ� 
ImmediateFlush=true:Ĭ��ֵ��true,��ν�����е���Ϣ���ᱻ��������� 
File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ����ݡ� 
DatePattern=��.'yyyy-ww:ÿ�ܹ���һ���ļ�����ÿ�ܲ���һ���µ��ļ�����ȻҲ����ָ�����¡��ܡ��졢ʱ�ͷ֡�����Ӧ�ĸ�ʽ���£� 
  1)��.'yyyy-MM: ÿ�� 
  2)��.'yyyy-ww: ÿ�� 
  3)��.'yyyy-MM-dd: ÿ�� 
  4)��.'yyyy-MM-dd-a: ÿ������ 
  5)��.'yyyy-MM-dd-HH: ÿСʱ 
  6)��.'yyyy-MM-dd-HH-mm: ÿ���� 
(4).RollingFileAppender ѡ�� 
Threshold=WARN:ָ����־��Ϣ�������Ͳ�Ρ� 
ImmediateFlush=true:Ĭ��ֵ��true,��ν�����е���Ϣ���ᱻ��������� 
File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ����ݡ� 
MaxFileSize=100KB: ��׺������KB, MB ������ GB. ����־�ļ�����ô�Сʱ�������Զ�����������ԭ���������Ƶ�mylog.log.1�ļ��� 
MaxBackupIndex=2:ָ�����Բ����Ĺ����ļ���������� 

3. ������־��Ϣ�Ĳ��֣����﷨Ϊ�� 
log4j.appender.appenderName.layout = fully.qualified.name.of.layout.class 
log4j.appender.appenderName.layout.option1 = value1 
�� 
log4j.appender.appenderName.layout.option = valueN 
���У�Log4j�ṩ��layout�����¼��֣� 
org.apache.log4j.HTMLLayout����HTML�����ʽ���֣��� 
org.apache.log4j.PatternLayout����������ָ������ģʽ���� 
org.apache.log4j.SimpleLayout��������־��Ϣ�ļ������Ϣ�ַ������� 
org.apache.log4j.TTCCLayout��������־������ʱ�䡢�̡߳����ȵ���Ϣ�� 

4�������ʽ���� 
�������ļ��п���ͨ��log4j.appender.A1.layout.ConversionPattern������־�����ʽ�� 
������ 
%p: �����־��Ϣ���ȼ�����DEBUG��INFO��WARN��ERROR��FATAL, 
%d: �����־ʱ�������ڻ�ʱ�䣬Ĭ�ϸ�ʽΪISO8601��Ҳ���������ָ����ʽ�����磺%d{yyy MMM dd HH:mm:ss,SSS}��������ƣ�2002��10��18�� 22��10��28��921 
%r: �����Ӧ�������������log��Ϣ�ķѵĺ����� 
%c: �����־��Ϣ��������Ŀ��ͨ�������������ȫ�� 
%t: �����������־�¼����߳��� 
%l: �����־�¼��ķ���λ�ã��൱��%C.%M(%F:%L)�����,������Ŀ�����������̣߳��Լ��ڴ����е�������������Testlog4.main(TestLog4.java:10) 
%x: ����͵�ǰ�߳��������NDC(Ƕ����ϻ���),�����õ���java servlets�����Ķ�ͻ����̵߳�Ӧ���С� 
%%: ���һ����%���ַ� 
%F: �����־��Ϣ����ʱ���ڵ��ļ����� 
%L: ��������е��к� 
%m: ���������ָ������Ϣ,��������־������Ϣ 
%n: ���һ���س����з���Windowsƽ̨Ϊ��\r\n����Unixƽ̨Ϊ��\n�������־��Ϣ���� 
������%��ģʽ�ַ�֮��������η�����������С��ȡ�����ȡ����ı��Ķ��뷽ʽ���磺 
1)%20c��ָ�����category�����ƣ���С�Ŀ����20�����category������С��20�Ļ���Ĭ�ϵ�������Ҷ��롣 
2)%-20c:ָ�����category�����ƣ���С�Ŀ����20�����category������С��20�Ļ�����-����ָ������롣 
3)%.30c:ָ�����category�����ƣ����Ŀ����30�����category�����ƴ���30�Ļ����ͻὫ��߶�����ַ��ص�����С��30�Ļ�Ҳ�����пո� 
4)%20.30c:���category������С��20�Ͳ��ո񣬲����Ҷ��룬��������Ƴ���30�ַ����ʹ���߽�Զ�������ַ��ص��� 

�����ڳ����е�ʹ�� 
�ڳ�����ʹ��Log4j֮ǰ������Ҫ��commons-logging.jar��logging-log4j-1.2.9.jar���뵽classpath�У�����log4j.properties����src��Ŀ¼�С��������Ϳ���ʹ���ˡ� 

1.�õ���¼�� 
ʹ��Log4j����һ�����ǻ�ȡ��־��¼���������¼�������������־��Ϣ�����﷨Ϊ�� 
public static Logger getLogger( String name)�� 
ͨ��ָ�������ֻ�ü�¼���������Ҫ�Ļ�����Ϊ������ִ���һ���µļ�¼����Nameһ��ȡ��������֣����磺 
static Logger logger = Logger.getLogger ( ServerWithLog4j.class.getName () ) ; 
ע���Ƽ�ʹ��commons-logging���log4j������־��¼ 
private static Log logger = LogFactory.getLog(Yourclass.class); 

2.�����¼��Ϣ����ʽ����־��Ϣ�� 
����������Ҫ����ִ����ϣ����Ϳ������ɵ�ʹ�ò�ͬ���ȼ������־��¼�����뵽�����¼��־���κεط������﷨���£� 
Logger.debug ( Object message ) ; 
Logger.info ( Object message ) ; 
Logger.warn ( Object message ) ; 
Logger.error ( Object message ) ; 

�ġ�Log4j�Ƚ�ȫ������� 
LOG4J������֮��ʹ���鼰��Խ��Խ���Ӧ�����ˣ�Log4J�����ļ�ʵ�������������̨���ļ����ع��ļ���������־�ʼ�����������ݿ���־���Զ����ǩ��ȫ�׹��ܡ�����һ��ʹ�þ͹����ˡ�

log4j.rootLogger=DEBUG,CONSOLE,A1,im
log4j.addivity.org.apache=true
# Ӧ���ڿ���̨
log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender
log4j.appender.Threshold=DEBUG
log4j.appender.CONSOLE.Target=System.out
log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
log4j.appender.CONSOLE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
#log4j.appender.CONSOLE.layout.ConversionPattern=[start]%d{DATE}[DATE]%n%p[PRIORITY]%n%x[NDC]%n%t[thread] n%c[CATEGORY]%n%m[MESSAGE]%n%n
#Ӧ�����ļ�
log4j.appender.FILE=org.apache.log4j.FileAppender
log4j.appender.FILE.File=file.log
log4j.appender.FILE.Append=false
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
# Use this layout for LogFactor 5 analysis
# Ӧ�����ļ��ع�
log4j.appender.ROLLING_FILE=org.apache.log4j.RollingFileAppender
log4j.appender.ROLLING_FILE.Threshold=ERROR
log4j.appender.ROLLING_FILE.File=rolling.log //�ļ�λ��,Ҳ�����ñ���${java.home}��rolling.log
log4j.appender.ROLLING_FILE.Append=true //true:��� false:����
log4j.appender.ROLLING_FILE.MaxFileSize=10KB //�ļ����ߴ�
log4j.appender.ROLLING_FILE.MaxBackupIndex=1 //������
log4j.appender.ROLLING_FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.ROLLING_FILE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

#Ӧ����socket
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
# ������־���ʼ�
log4j.appender.MAIL=org.apache.log4j.net.SMTPAppender
log4j.appender.MAIL.Threshold=FATAL
log4j.appender.MAIL.BufferSize=10
log4j.appender.MAIL.From=web@www.wuset.com
log4j.appender.MAIL.SMTPHost=www.wusetu.com
log4j.appender.MAIL.Subject=Log4J Message
log4j.appender.MAIL.To=web@www.wusetu.com
log4j.appender.MAIL.layout=org.apache.log4j.PatternLayout
log4j.appender.MAIL.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n
# �������ݿ�
log4j.appender.DATABASE=org.apache.log4j.jdbc.JDBCAppender
log4j.appender.DATABASE.URL=jdbc:mysql://localhost:3306/test
log4j.appender.DATABASE.driver=com.mysql.jdbc.Driver
log4j.appender.DATABASE.user=root
log4j.appender.DATABASE.password=
log4j.appender.DATABASE.sql=INSERT INTO LOG4J (Message) VALUES (��[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n��)
log4j.appender.DATABASE.layout=org.apache.log4j.PatternLayout
log4j.appender.DATABASE.layout.ConversionPattern=[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n

log4j.appender.A1=org.apache.log4j.DailyRollingFileAppender
log4j.appender.A1.File=SampleMessages.log4j
log4j.appender.A1.DatePattern=yyyyMMdd-HH��.log4j��
log4j.appender.A1.layout=org.apache.log4j.xml.XMLLayout
#�Զ���Appender
log4j.appender.im = net.cybercorlin.util.logger.appender.IMAppender
log4j.appender.im.host = mail.cybercorlin.net
log4j.appender.im.username = username
log4j.appender.im.password = password
log4j.appender.im.recipient = corlin@cybercorlin.net
log4j.appender.im.layout=org.apache.log4j.PatternLayout
log4j.appender.im.layout.ConversionPattern =[framework] %d - %c -%-4r [%t] %-5p %c %x - %m%n



