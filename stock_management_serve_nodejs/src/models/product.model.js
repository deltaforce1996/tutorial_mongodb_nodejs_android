const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ProductSchema = new Schema({
  product_name: { type: String, required: true },
  product_amount: { type: Number, required: true },
  product_exp: { type: String, required: true },
  product_price: { type: Number, required: true }
});

module.exports = mongoose.model('products', ProductSchema);
