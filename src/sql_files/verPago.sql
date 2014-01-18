SELECT FP.Saldo,F.TotalFacturado
FROM Factura AS F,FacturasPendientes AS FP
WHERE F.Estado ='A' AND F.idFactura=FP.idFactura AND F.idFactura=? AND F.Concepto='Apartado';
