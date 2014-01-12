SELECT F.Fecha,C.Nombre,V.Nombre,F.TipoPago,F.TotalFacturado,F.Nota,F.Descuento
FROM factura AS F,persona AS C, persona AS V
WHERE F.idFactura=? AND F.Estado ='Cerrada' AND F.idCliente=C.idPersona AND V.idPersona=F.idVendedor;

