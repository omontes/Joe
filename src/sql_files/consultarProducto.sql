SELECT Nombre,Precio,Costo,idCategoriaProd,Descripcion,idProducto
FROM producto
WHERE idProducto=? and Estado='A';