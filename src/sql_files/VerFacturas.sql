SELECT F.idFactura AS NumFact,F.Fecha,C.Nombre AS Cliente,V.Nombre AS Vendedor,TotalContado+TotalTarjeta AS Total 
FROM factura AS F,persona AS C, persona AS V
WHERE F.Concepto ='Cancelada' AND F.Estado='A' AND F.idCliente=C.idPersona AND V.idPersona=F.idVendedor
ORDER BY F.idFactura DESC LIMIT 100;
