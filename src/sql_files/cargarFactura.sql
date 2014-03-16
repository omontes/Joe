SELECT F.Fecha,C.Nombre,V.Nombre,F.`TotalContado`+F.`TotalTarjeta`,F.Nota,F.Descuento
FROM factura AS F,persona AS C, persona AS V
WHERE F.idFactura=? AND F.Estado='A' AND 
(F.Concepto ='Cancelada' OR F.Concepto='Apartado' OR F.Concepto='Credito') 
AND F.idCliente=C.idPersona AND V.idPersona=F.idVendedor;

