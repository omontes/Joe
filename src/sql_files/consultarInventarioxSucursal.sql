select I.idProducto,P.Nombre,I.cantidad,
P.Precio,P.Costo,C.Descripcion from inventario as I
inner join producto as P on P.idProducto=I.idProducto
inner join categoria as C on P.idCategoriaProd=C.idCategoria;