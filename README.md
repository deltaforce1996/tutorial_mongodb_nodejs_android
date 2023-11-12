
# Step tutorial android connect restful api with mongodb
## 🛠️ Tools
- Android Studio

- Visual studio code

- Postman
## 🔥 Backend Nodejs, Mongodb, Ngrok
1 - ติดตั้ง [Docker Desktop](https://www.docker.com/products/docker-desktop/) ใช้สำหรับสร้าง mongo serve [วิธีติดตั้ง](https://www.youtube.com/watch?v=1G4xuqoLepI)

2 - ติดตั้ง [Mongo Compass](https://www.mongodb.com/try/download/compass) 

3 - ติดตั้ง [Ngrok](https://ngrok.com/download) ใช้สำหรับการ forward port ให้สามารถ access serve ของเราจากข้างนอก Network [เพิ่มเติม](https://www.borntodev.com/c/webdeveloper/%E0%B9%81%E0%B8%99%E0%B8%B0%E0%B8%99%E0%B8%B3-ngrok-%E0%B8%AA%E0%B8%A3%E0%B9%89%E0%B8%B2%E0%B8%87-public-url-%E0%B9%83%E0%B8%AB%E0%B9%89-localhost-%E0%B9%81%E0%B8%9A%E0%B8%9A-easy-5fd1bab2e1ebb)

4 - ติดตั้ง [Nodejs](https://nodejs.org/en/download?fbclid=IwAR1IW51IVWktd2dw2mUIRQjoN1UjlO5db89dkFqd0yhPNHMcBKdbhZGPj68)

5 - ติดตั้ง [Postman](https://www.postman.com/downloads/) ใช้สำหรับไว้ทดสอบ restful api

### 👋 ขั้นตอน Run mongodb docker
- สร้างไฟล์ `docker-compose.yaml`
```
version: '3'
services:
  mongodb:
    image: mongo:latest
    container_name: my-mongo-serve
    ports:
      - "27018:27017"
    networks:
      - my-network
    restart: always
networks:
  my-network:
    driver: bridge
```
- run docker compose เพื่อลง mongodb
```
docker-compose up -d 
```

### 👋 ขั้นตอนสร้าง web server ด้วย nodejs
- สร้าง project เริ่มต้นโดยใช้คำสั่ง
```
npm init -y
```

- ติดตั้ง node package ที่ต้องใช้  `express`, `body-parser`
```
npm install express body-parser
```

- ติดตั้ง node package เพื่อใช้ query ข้อมูลมาจาก database mongodb `mongoose`
```
npm install mongoose
```
- เปิด porject ที่สร้างไว้แล้วสร้างไฟล์ลงใน `root` ชื่อ `server.js`
```
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

app.get('/', (req, res) => {
  res.json({ message: 'Ahoy! From Server!!' });
});

app.listen(4000, () => {
  console.log('Application is running on port 4000');
});
```

- บันทึกจากนั้นก็ใช้คำสั่ง 
```
node server.js
```

- ผลลัพธ์การ run server.js
  
![image](https://github.com/deltaforce1996/tutorial_mongodb_nodejs_android/assets/67696458/60b87d45-9e48-44ea-aeaa-bd6d9a2fb47b)

- ผลลัพธ์ Request server
  
![image](https://github.com/deltaforce1996/tutorial_mongodb_nodejs_android/assets/67696458/310c55e8-2996-4ce1-ac07-90430d7de1c6)


## 🔥 Frontend Android App, GSON Format, Retrofit  
1 - ติดตั้ง [Java JDK](https://www.oracle.com/java/technologies/downloads/#jdk21-windows) พร้อมทั้ง set path evironment

2 - ติดตั้ง [Android Studio]("https://developer.android.com/studio")

3 - ติดตั้ง Plugin `GSON Format` ลง Android Studio

### 👋 Android connect restful api ใช้ Retofit, OKHtttp
- สร้าง Directory

![image](https://github.com/deltaforce1996/tutorial_mongodb_nodejs_android/assets/67696458/c7523e6e-8549-43d2-be00-cc8fccfe8657)

- เปิดไฟล์ `build.gradle.kts` Module:app เพิ่ม Libs กด sync now
```
dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
  /** ส่วนอื่น... */
}
```
