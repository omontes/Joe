select I.idProducto,P.Nombre,I.cantidad,
P.Precio,P.Costo,C.Descripcion AS categoria from inventario as I
inner join producto as P on P.idProducto=I.idProducto
inner join categoria as C on P.idCategoriaProd=C.idCategoria
where P.Estado='A' and I.`idUbicacionProducto`='1';