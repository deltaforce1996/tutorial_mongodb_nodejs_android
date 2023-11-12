const ProductService = require('../services/product_servie.service');

module.exports = (app) => {
    app.route('/api/v1/product').post(ProductService.insertProduct);
    app.route('/api/v1/product/:id').put(ProductService.updateProduct)
    app.route('/api/v1/product/:id').delete(ProductService.deleteProduct)
    app.route('/api/v1/product/:id').get(ProductService.getProductById);
    app.route('/api/v1/product').get(ProductService.getAllProducts);
};
