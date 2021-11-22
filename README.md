# spring-mvc-lab-5
ISD Lab#5: Simple Currency Converter Web Application using Java, Spring Boot.

# Homework requirements
Sinh viên hãy thực hiện lại bài hướng dẫn trên để hiểu cách hoạt động hệ thống, ứng dụng
xây dựng Web MVC dùng Java.

Yêu cầu: Sinh viên xây dựng một trang web đơn giản để tính toán việc chuyển đổi tiền tệ
từ $ sang VNĐ bằng cách sử dụng Spring MVC và Spring Boot.

Hai tham số cần cung cấp là số tiền cần đổi, tỉ giá $, kết quả trả về tiền VNĐ.

# Result:
Web app runs at ```localhost:8080/convert/{amount}/{exchangeRate}```
<kbd>![!](https://github.com/mq149/spring-mvc-lab-5/blob/master/results/lab5-res-img.png?raw=true "API from Web App")</kbd>

## Model: ```CurrencyConverter.java```
```
public class CurrencyConverter {
  public float amount;
	public float exchangeRate;
	public Object result;
	public CurrencyConverter(float amount, float exchangeRate) {
		super();
		this.amount = amount;
		this.exchangeRate = exchangeRate;
	}
	
	public void convert() {
		result = amount * exchangeRate;
	}
}
```

## Controller: ```CurrencyConverterController.java```
```
@Controller
public class CurrencyConverterController {
	@GetMapping("/convert/{amount}/{exchangeRate}")
	public String convert(@PathVariable float amount, @PathVariable float exchangeRate, Model m) {
		CurrencyConverter cc = new CurrencyConverter(amount, exchangeRate);
		cc.convert();
		m.addAttribute("res", cc.result);
		return "convert";
	}
}
```

## View: ```convert.html```
```
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Currency Converter</title>
</head>
<body>
    <h1>Convert result: </h1>
    <div th:text="${res}"></div>
</body>
</html>
```
