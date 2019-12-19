package edu.mum.cs544.apigateway.domain;


public class AppEnv{
    private static final String userService = "http://localhost:8082";
    private static final  String productService = "http://localhost:8083";//"http://10.10.63.206:8083";
    private static final  String cartService = "http://localhost:8083";//"http://10.10.63.206:8083";//http://172.19.141.187:8083";

    public static String getUserService() {
        return userService;
    }

    public static String getProductService() {
        return productService;
    }

    public static String getCartService() {
        return cartService;
    }
}
