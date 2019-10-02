# Prototype App

####  Geliştirmemi istediğiniz projede kullanılan teknolojiler:

- Uygulama **SpringBoot** framework ile geliştirildi.
- Dependency management için **Maven** kullanıldı.
- Cache kütüphanesi olarak **Ehcache** kullanıldı.
- Loglama için **Log4j** kütüphanesi kullanıldı.
- Json convertor işlemleri için **Gson** kütüphanesi kullanıldı.

####  Uygulamanın Çalıştırılması:

Uygulamanın içine (pom.xml içerisinde) **Tomcat** gömülü olarak gelmektedir. Main sınıfından direk çalıştırılabilir.

####  Uygulama İstek URL adresleri:

SoapUI üzerinden çalışmak için gerekli olan wsdl URL'i:

`http://localhost:8080/ws/subscribers.wsdl`

- getAllSubscribers : `localhost:8080/ws/` adresinden aşağıdaki istek atılır.

```html
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sub="http://www.ezgiozkaya/subscriber">
   <soapenv:Header/>
   <soapenv:Body>
      <sub:getAllSubscribersRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```
-  getSubscriberById :  `localhost:8080/ws/` adresinden aşağıdaki istek atılır.

```html
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sub="http://www.ezgiozkaya/subscriber">
   <soapenv:Header/>
   <soapenv:Body>
      <sub:getSubscriberByIdRequest>
         <sub:id>3</sub:id>
      </sub:getSubscriberByIdRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Postman üzerinden istek denemeleri için :

- `localhost:8080/subscriber` adresine **POST** metoduyla aşağıdaki veri örneği gibi istek atılarak kullanıcı oluşturma işlemi yapılır.

```javascript
{
        "id": 5,
        "name": "Ezgi",
        "msisdn": "123456789"
}
```
- `localhost:8080/subscriber` adresine **PUT**  metoduyla aşağıdaki veri örneği gibi istek atılarak ilgili kullanıcı güncelleme işlemi yapılır.

```javascript
{
        "id": 5,
        "name": "Ayşe",
        "msisdn": "1234567"
}
```

- `localhost:8080/subscriber/id` adresine **DELETE** metoduyla ilgili kullanıcının ID numarası verilerek kullanıcı silme işlemi yapılır.
