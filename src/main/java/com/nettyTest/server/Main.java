package com.nettyTest.server;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Main {
    public static void main(String[] args){
        /*String SOAP_ACTION="http://www.hztianque.com/addIssues";
        String NAMESPACE="http://www.hztianque.com/";
        String METHOD_NAME="addIssues";
        String URL="http://171.35.109.17:9010/webService/issueSrWeb"; */
        String SOAP_ACTION="http://WebXml.com.cn/getSupportCity";
        String NAMESPACE="http://WebXml.com.cn/";
        String METHOD_NAME="getSupportCity";
        String URL="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        SoapObject test;
        SoapObject resultSoapObject;
        SoapObject request=new SoapObject(NAMESPACE,METHOD_NAME);
        request.addProperty("byProvinceName","河南");
        /*request.addProperty("key","34939C51AF34217DE053A2451A0A51F3");
        request.addProperty("userName","srpx");
        //request.addProperty("issueContentReal",fileBase64);
        //request.addProperty("fileName",fileName);
        request.addProperty("occurDate","2019-01-02 13:26:00");
        request.addProperty("issueContent","vivo律师所");
        request.addProperty("occurLocation","无网格");*/
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        //envelope.dotNet = true;// 注意：这个属性是对dotnetwebservice协议的支持,如果dotnet的webservice需要设置成true
        envelope.bodyOut = request;
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try{
            HttpTransportSE transportSE=new HttpTransportSE(URL);
            transportSE.call(NAMESPACE+METHOD_NAME,envelope);
            resultSoapObject=(SoapObject)envelope.getResponse(); //获取到返回的结果，并强制转换成SoapObject对象
            System.out.println(resultSoapObject);
            //test = (SoapObject)resultSoapObject.getProperty(0); //该对象中还嵌套了一个SoapObject对象，需要使用getProperty(0)把这个对象提取出来
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
