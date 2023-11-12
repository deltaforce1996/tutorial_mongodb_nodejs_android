const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const ProductRoutes = require('./src/routes/prodcut.route');

const app = express();
app.use(bodyParser.json());

mongoose.connect('mongodb://localhost:27018/strore_db')
.then(() => console.log('MongoDB Connected...'))
.catch(err => console.log(err));


ProductRoutes(app);

app.get('/', (req, res) => {
  res.json({ message: 'Ahoy! From Server!!' });
});

app.listen(4000, () => {
  console.log('Application is running on port 4000');
});