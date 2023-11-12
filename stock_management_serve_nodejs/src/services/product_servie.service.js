const ProductModel = require('../models/product.model');
const { successfully } = require('../utils/response.util')

exports.insertProduct = async (req, res) => {
    try {
        const { product_name, product_amount, product_exp, product_price } = req.body;

        const newProduct = new ProductModel({
            product_name,
            product_amount,
            product_exp,
            product_price,
        });

        const savedProduct = await newProduct.save();
        res.status(201).json(successfully('Create new product successfully.', savedProduct));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};


exports.updateProduct = async (req, res) => {
    try {
        const newProduct = req.body;
        const prodcutId = req.params.id

        const updatedProduct = await ProductModel.findByIdAndUpdate(
            prodcutId,
            newProduct,
            { new: true, runValidators: true }
        );

        if (!updatedProduct) {
            return res.status(404).json({ message: 'Product not found' });
        }
        res.json(successfully('Updated product successfully.', updatedProduct));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};


exports.deleteProduct = async (req, res) => {
    try {
        const prodcutId = req.params.id

        const deletedProduct = await ProductModel.findByIdAndDelete(prodcutId);
        if (!deletedProduct) {
            return res.status(404).json({ message: 'Product not found' });
        }
        res.status(204).json(successfully('Deleted product successfully.', deletedProduct));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};


exports.getAllProducts = async (req, res) => {
    try {
        const products = await ProductModel.find();
        if (products.length === 0) return res.status(404).json({ message: 'Product not found' });
        res.json(successfully('Find all product successfully.', products));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};


exports.getProductById = async (req, res) => {
    try {
        const prodcutId = req.params.id

        const product = await ProductModel.findById(prodcutId);
        if (!product) {
            return res.status(404).json({ message: 'Product not found' });
        }
        res.json(successfully('Find product successfully.', product));
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};

