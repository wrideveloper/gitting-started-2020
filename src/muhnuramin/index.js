const express=require('express')
const app=express()
app.use(function(req,res,next){
    console.log("lewat middleware pertama");
    next();
});

app.use(express.json());
app.get("/data", function(req,res,next){
    if(req.body.name=="aku"){
        console.log("selamat datang aku");
        next();
    }else{
        res.send("harus aku");
    };
    
    console.log("lewat middleware Kedua");
    next();
},function(req,res){
res.send("hallo "+req.body.name);
});

app.get('/user',
    function(req,res){
       res.send("ini route user");
    }
   
);
app.get('/contact',function(req,res){
    res.send("ini route my contact");
});
app.listen(3000,function(){
    console.log("app is listening");
});