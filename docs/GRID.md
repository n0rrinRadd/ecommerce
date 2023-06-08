# Selenium Grid

## Browser Access

Hub - http://ecommerce.local:8080/#/

## Capabilities

http://ecommerce.local:8080/#/capabilities/

_for example_

To run Chrome version 67

```
browserName: "chrome"
version: "67.0"
enableVNC: true
enableVideo: false
```

The capabilities would look like

```
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName("chrome");
capabilities.setVersion("67.0");
capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", false);

```

## Connect to Hub

`driver = new RemoteWebDriver(new URL("http://ecommerce.local:4444/wd/hub"), capabilities);`
